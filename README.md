# Company Shared Project

Welcome! This repository contains a set of reusable building blocks you can drop into your services:

- Reusable message models (generated from OpenAPI)
- A Spring Boot starter to simplify messaging integration
- A BOM (Bill of Materials) to align versions across modules

The project is organized as a standard multi‑module Maven build and is ready to import into your favorite IDE.

Quick start
1) Build everything
- From the project root, run: `mvn clean package`

2) Import in your IDE
- Open the root `pom.xml` in IntelliJ IDEA, VS Code (with Maven), or Eclipse.
- After the first build, the IDE will detect the generated sources automatically.

3) Use the shared models
- Add a dependency on the model module you need (for example, `company-model-account`).
- Then import and use the generated types, e.g. `com.mycompany.shared.model.account.AccountDto`.

What’s inside
- company-message-models
  - company-message-models-common (shared pieces for generated models)
  - company-model-account (models generated from `account.yaml`)
  - company-model-transfers (models generated from `transfers.yaml`)
- company-shared-messages (example usage of the generated models)
- company-messaging-starter (Spring Boot starter)
- company-bom (Bill of Materials)

About the generated code
- The OpenAPI specs live in each model module under `src/main/resources` (for example, `account.yaml`).
- During the Maven build, the Java sources are generated into the Maven `target` directory and compiled automatically.
- Nothing generated is committed to source control.

Common tasks
- Full build: `mvn clean package`
- Build just one model module (and what it depends on):
  - `mvn -pl company-message-models/company-model-account -am clean package`

Adding a new model module
1) Create a new module under `company-message-models` with your OpenAPI spec in `src/main/resources`.
2) Copy the existing model module’s POM configuration as a template.
3) Choose a Java package for your generated models (for example, `com.mycompany.shared.model.payments`).
4) Add a dependency on this new module wherever you want to use these models.

Troubleshooting
- My IDE cannot find generated classes (e.g., `AccountDto`).
  - Run `mvn clean package` from the root, then reimport Maven projects in your IDE.
- I see build errors about generated test files.
  - We disable test generation for models to keep things lightweight. If you changed generator settings, turn off model test generation.
- Annotations like `jakarta.validation` or Jackson are not resolved.
  - Ensure the model module depends on the standard annotation libraries (Jakarta Validation/Jackson). The provided POMs include them.

Need help?
- Open an issue with the module name and the command you ran (for example, `mvn clean package`) and we’ll help you get going.
