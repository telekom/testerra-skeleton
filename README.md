# Testerra 2 Skeleton

This project is a simple skeleton project for [Testerra framework]([https://github.com/telekom/testerra]) addressing basic features,  
file and directory structure and common best practices to getting you and your project work as fast as possible.  
For simplicity, we will use Gradle as build and dependency management tool. 

This project uses Testerra 2.

For more demos of extended Testerra features checkout https://github.com/T-Systems-MMS/testerra-demo.

Note: *For a Testerra 1 Skeleton go to https://github.com/telekom/testerra-skeleton/tree/testerra1* 

## Perquisites

This project is an implementation of the [getting started](http://docs.testerra.io/testerra/2-latest/index.html#_getting_started) tutorial.

**Note:** All you have to do is, to set up an [own selenium server](http://docs.testerra.io/testerra/2-latest/index.html#_setup_selenium)

## Demo App
For sample page objects and easy testcases we use https://the-internet.herokuapp.com/ as base url for testing.

## Execution

You can simply execute the provided tests for the demo app by running following Maven command.
```bash
gradle test
```

or open the project in your IDE and run the files under `src/test` of the respective project.

You will find the Testerra report under `test-report/report-ng/index.html`.

## What this skeleton project offers you

### Page object and GuiElement
You will see how to use Testerra `Page` objects and work with basic features and selectors of `UiElement`.

### Properties
This project shows how you can set up a basic `test.properties` file to get things started locally.

### TestNG execution
You get in touch how to configure a TestNG suite file in Gradle.

### Localization
To get in touch with localization, this skeleton project provides a simple resource bundle for english language.
The usage can be seen in some `Page` object classes of this project.

### Fails-Annotation
The project shows you how to use Testerra's `@Fails` annotation for marking test as expected errors.

### Failure Corridor
The skeleton shows you how to use `FailureCorridor` annotations and configuration in `test.properties`.

## Code of Conduct

This project has adopted the [Contributor Covenant](https://www.contributor-covenant.org/) in version 2.0 as our code of conduct. Please see the details in our [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md). All contributors must abide by the code of conduct.

## Working Language

We decided to apply _English_ as the primary project language.

Consequently, all content will be made available primarily in English. We also ask all interested people to use English as language to create issues, in their code (comments, documentation etc.) and when you send requests to us. The application itself and all end-user faing content will be made available in other languages as needed.

## Support and Feedback
The following channels are available for discussions, feedback, and support requests:

| Type                     | Channel                                                |
| ------------------------ | ------------------------------------------------------ |
| **Issues**   | <a href="https://github.com/telekom/testerra-skeleton/issues/new/choose" title="Issues"><img src="https://img.shields.io/github/issues/telekom/testerra-skeleton?style=flat"></a> |
| **Other Requests**    | <a href="mailto:testerra@t-systems-mms.com" title="Email us"><img src="https://img.shields.io/badge/email-CWA%20team-green?logo=mail.ru&style=flat-square&logoColor=white"></a>   |

## How to Contribute

Contribution and feedback is encouraged and always welcome. For more information about how to contribute, the project structure, as well as additional contribution information, see our [Contribution Guidelines](./CONTRIBUTING.md). By participating in this project, you agree to abide by its [Code of Conduct](./CODE_OF_CONDUCT.md) at all times.

## Contributors

At the same time our commitment to open source means that we are enabling -in fact encouraging- all interested parties to contribute and become part of its developer community.

## Licensing

Copyright (c) 2020 Deutsche Telekom AG.

Licensed under the **Apache License, Version 2.0** (the "License"); you may not use this file except in compliance with the License.

You may obtain a copy of the License at https://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the [LICENSE](./LICENSE) for the specific language governing permissions and limitations under the License.
