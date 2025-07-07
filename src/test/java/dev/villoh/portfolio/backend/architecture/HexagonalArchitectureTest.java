package dev.villoh.portfolio.backend.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class HexagonalArchitectureTest {

    private static final String BASE_PACKAGE = "dev.villoh.portfolio.backend";

    private final JavaClasses classes = new ClassFileImporter()
        .importPackages(BASE_PACKAGE);

    @Test
    void domain_should_not_depend_on_application_or_infrastructure() {
        ArchRuleDefinition.noClasses()
            .that().resideInAPackage(BASE_PACKAGE + ".domain..")
            .should().dependOnClassesThat()
            .resideInAnyPackage(
                BASE_PACKAGE + ".application..",
                BASE_PACKAGE + ".infrastructure.."
            )
            .because("the domain layer should be pure and independent")
            .check(classes);
    }

    @Test
    void application_should_only_depend_on_domain() {
        ArchRuleDefinition.noClasses()
            .that().resideInAPackage(BASE_PACKAGE + ".application..")
            .should().dependOnClassesThat()
            .resideInAnyPackage(
                BASE_PACKAGE + ".infrastructure.."
            )
            .because("the application layer should not know about infrastructure")
            .check(classes);
    }

    @Test
    void application_should_depend_on_domain_but_not_adapters() {
        ArchRuleDefinition.noClasses()
            .that().resideInAPackage(BASE_PACKAGE + ".application..")
            .should().dependOnClassesThat()
            .resideInAnyPackage(
                BASE_PACKAGE + ".infrastructure.adapter.."
            )
            .because("application should not depend on any adapter")
            .check(classes);
    }
}
