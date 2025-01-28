## Quiz:
1. Why are semicolons left off the end of decorator expressions?
- They expect dependencies to be passed in after the parenthesis.
- They expect input values to be passed in after the parenthesis.
- They expect arguments to be passed in after the parenthesis.

Answer: They expect arguments to be passed in after the parenthesis.

2. Which decorator property do you use to tell Angular the components to load when you launch your app?
- providers
- declarations
- bootstrap

Answer: bootstrap

3. What does Angular do with DOM elements when the value of an *ngIf expression is false?
- Angular collapses the elements in the DOM.
- Angular hides the elements in the DOM.
- Angular removes the elements from the DOM.

Answer: Angular removes the elements from the DOM.

4. How would you use a standalone component in an existing Angular module?
- Add the component to the providers array in the module's decorator
- Add the component to the imports array in the module's decorator
- Add the component to the declarations array in the module's decorator

Answer: Add the component to the imports array in the module's decorator

5. Which binding would you use to dynamically assign values to attributes on a standard HTML element?
- event binding
- property binding
- interpolation

Answer: property binding
Event Binding lets you assign actions to DOM events like `keyup` and `click`.
Interpolation lets you display dynamic content as text in the UI.

6. How do you prevent naming collisions with standard HTML elements like <button> and <input>?
- Use Shadow DOM to encapsulate the component's selector.
- Use at least one dash in the name for the component's selector.
- Use the template property to define the components selector.

Answer: Use at least one dash in the name for the component's selector.

7. How often does Angular call the constructor for a component?
- once
- three times
- twice

Answer: once