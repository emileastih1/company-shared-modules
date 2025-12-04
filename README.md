# Company Shared Project (Full Sample)

This is a fully generated sample multi-module Maven project that documents a "shared modules + starter + BOM" approach.

Import into IntelliJ:
1. File -> Open -> select `company-shared-project-root/pom.xml` (or open the root `pom.xml`).
2. Run `mvn -U clean install` from the project root.

Modules:
- company-message-models (parent for message model modules)
  - company-message-models-common
  - company-model-account
  - company-model-transfers
- company-shared-messages
- company-messaging-starter
- company-bom

Notes:
- The starter includes an auto-configuration registration file so it behaves as a real Spring Boot starter.
- OpenAPI generation plugin is configured but not executed by default — enable it by adding executions if you want code generation.
