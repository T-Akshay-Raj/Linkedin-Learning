# Angular

## Prerequisite Softwares
- Node.js(check version using :  node -v)
- NPM(check version using :  npm -v)
- IDE: VS Code(Recommended)
- Angular (Check version) : ng -v or ng --version
- Cmder (command line tool for non windows OS)

>Note: node.js can be downloaded from [nodejs](https://nodejs.org) and VS code from [vscode](code.visualstudio.com)

## Prerequisite technical knowledge
- HTML
- CSS/SCSS
- TypeScript/Java Script

> Angular official Documentation at [Angular docs](https://angular.io/docs)

## Angular CLI
- Install Angular cli
    - npm install -g @angular/cli  (Installs latest version)
    - npm install -g @angular/cli @11 (Installs specific version)
- [Angular CLI overview](https://angular.io/cl)



## Angular commands:
Angular's command line tool is called ng

## Create Sample dryrun angular project(Note: Switch to folder where you want to create project)
ng new app-name --dry-run
- All other ways to generate a new application can be found using help
    -   ng new --help
 
- Eg: To create a new angular project which supports scss(called as sass) and enable routing
    - ng new app-name --style=scss --routing
    - Run the application using: ng serve  
 
> Note: After creating the project, you may open it directly in vs code using below steps, First navigate to workspace folder where app is created and in cmd enter 'code .'


## Run angular application
- command: 'ng serve'
- creates a local dev environment for the application, [local host url]("http://localhost:4200")
- Tip to run and open in browser: 'ng serve --open'

> For ng server options list, 'ng serve --help'

# Project Structure
- source folder
  - app folder
  - main.ts file
  - server.ts file
  - styles.scss: serves as global styles

- Package.json - holds project information, scripts and project dependency information(similar to pom.xml)
- angular.json - contains config information used by cli for various angular phases(like build, serve, test, lint)
- karma.conf.js - used by cli for test related information
- tsconfig.json - contains compiler options
- tsconfig.app.json - contains compiler options for application code
- tsconfig.spec.json - contains compiler options for test code 
- e2e folder:
  - protractor.conf.js - contains compiler options for test files
- environments folder - contains environment specific files

## Core Building Block of Angular

### Decorators
- Decorators are functions that returns functions
- They convey angular on code functionality and how to inject code
- Marked using '@' symbol
- Invoked during runtime with arguments
- Example decorators:
  - @NgModule() for modules
  - @Component() for components
  - @Injectable() for services
  - @Pipe() for pipes
  - @Directive() for directives
  - @Input for data flowing into a component
  - @Output for data flowing out of a component
- Common decorator errors
  - Missing parantheses
  - Missing properties
  - Missing property values
  - Adding semicolon at the end of decorator
  - Trouble shooting: use 'ng build' and 'ng serve' commands to check for errors
 
#### @Component Decorator
Contains 4 sections
- selector
- imports: takes an array of references
- templateUrl(for reference to html file) or template(for inline html template)
- styelUrl (for styles url) or styles [](for inline css)
 
### Modules
Modules are collection of files that work together
- Might include components, services or pipes
- Naming convention: end file with module.ts e.g. (moduleName.module.ts)
- Generate a module using cli 'ng generate module moduleName' or 'ng g m moduleName'
- [Introduction to modules]( https://angular.io/guide/architecture-modules)
- [NgModules] (https://angular.io/guide/ngmodules)

### Components
Components are main building blocks in angular apps. A Component file can be categorised into import section, component decorator and export section

##### Component attributes:
imports: holds an array of dependent modules, directives, pipes, etc
providers: array of all the code you want to make it available for component(dependency injection happens here)


#### To create a component using the Angular CLI:

From a terminal window, navigate to the directory containing your application.
Run the 'ng generate component componentName' or 'ng g c componentName' command , where componentName is the name of your new component. This will create a new component under src/app/componentName
By default, this command creates the following:

- A directory named after the component
    - A component file, componentName.component.ts
    - A template file, componentName.component.html
    - A CSS file, componentName.component.css
    - A testing specification file, componentName.component.spec.ts


#### Standalone components
Standalone components lets you use files without modules
- To make any component standalone, add attribute standalone=true in the component

#### Nested Component
To Nest a component in another component, add its selector name with tags in the base component.
for e.g. if child component has selector value as app-home, add <app-home></app-home> in the base component


### Service

Generate a service using command
ng generate service serviceName
or
ng g s serviceName

### Pipe

#### Pipes use case:
Use pipes to manipulate content on UI,(e.g. change letter case)
Can compose them together(Output of one pipe as input of another pipe)
Angular includes 13 pipes with all new projects

1. Pure Pipe
2. Impure Pipe


#### Pure Functions:
A Function that returns the same output for the same inputs


## Structural Directives
*ngIf : The Boolean expression to evaluate as the condition for showing a template.
*ngFor : A structural directive that renders a template for each item in a collection. The directive is placed on an element, which becomes the parent of the cloned templates.

## HTML Tags
- <input>: The input element represents a typed data field, usually with a form control to allow the user to edit the data.
- <div>: The div element has no special meaning at all. It represents its children. It can be used with the class, lang, and title attributes to mark up semantics common to a group of consecutive elements.
- <button>: The button element represents a button labeled by its contents.
- <i>: If the a element has an href attribute, then it represents a hyperlink (a hypertext anchor) labeled by its contents.
- <p>: The p element represents a paragraph.
- <span>: The span element doesn't mean anything on its own, but can be useful when used together with the global attributes, e.g. class, lang, or dir. It represents its children.

### List
- <ul>: The ul element represents a list of items, where the order of the items is not important — that is, where changing the order would not materially change the meaning of the document.
- <li>: The li element represents a list item. If its parent element is an ol, ul, or menu element, then the element is an item of the parent element's list, as defined for those elements. Otherwise, the list item has no defined list-related relationship to any other li element.
    
## Angular Tags
<ng-template>: The <ng-template> is an Angular element for rendering HTML. It is never displayed directly.




### Create files using schematics(ng generate)
- Get list of schematics and options available using 'ng generate --help'
- example schematics are (application, class, component, module, library, enum, module, interface, service etc)
- Example to generate component: 'ng generate component component-name' or 'ng generate component component-name --dry-run' or 'ng g c component-name --dry-run' (It creates 4 files : .ts, .html, .scss and .spec.ts file)
- Example to generate module : 'ng generate module module-name'. It generates a module and .ts file in it)

## popular angular commands
- ng: list all available commands
- ng new(alias n): Creates a new workspace and an initial angular app
- ng add: Adds support for an external library to your project
- ng build (alias b): compile code and output files into build directory
- ng serve(alias s): compile code and launch and dev server and watch the changes(means changes get auto reload instead of refresing window each time)
- ng generate(alias g): to add new files using angulars builtin boilerplates(for all options "ng generate --help")
- ng lint(alias l): runs angular lint
- ng test(alias t): run unit test in a project
- ng run: Runs an architect target with an optional custom binder configuration defined in your project
- ng help: to get help on angular commands
- ng --version(alias v): to check angular cli version
- ng e2e(alias e): run intergation tests
- ng update: updates application and its dependencies

>Tip: Execute 'ng build --prod' for relatively optimised build

### Data Binding:
UniDirectional data binding using interpolation and property binding
Two way binding using Event Binding


#### Interpolation
Interpolation lets you display dynamic content as text in the UI. uses {{ }}

#### Property Binding

### Event Binding
Event Binding lets you assign actions to DOM events like `keyup` and `click`.


## Additional helpful Plugins or tools
- Angular Language service(available as plugin in vs code by angular.dev)
- Angular dev tools: a browser extension which gives detailed debugging information in realtime when working with browser
- Angular scematics: Custom code collection, reusable across multiple projects


## Commands
### Test
Run Unit test(Auto run again on changes to tests): ng test
Run Unit Test(Without re run Doesn't auto run on change): ng test --no-watch
Code Coverage: ng test --code-coverage



- Jasmine: Testing Framework

### Lifecyle hooks
- ngOnInit() of OnInit: a lifecycle hook that is called after angular has iniatilized all data-bound properties.

```
NPM Commands
npm install        install all the dependencies in your project
npm install <foo>  add the <foo> dependency to your project
npm test           run this project's tests
npm run <foo>      run the script named <foo>
npm <command> -h   quick help on <command>
npm -l             display usage info for all commands
npm help <term>    search for help on <term>
npm help npm       more involved overview
```


# Update Angular version
- Verify assisted changes between from version and to version using [Angular Update](https://update.angular.com)
- Always suggested to perform incremental upgrade

## Deploy to github pages
- Install github pages using cli
    - ng install -g @angular-cli-ghubpages


