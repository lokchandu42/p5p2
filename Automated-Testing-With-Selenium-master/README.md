# Automated-Testing-With-Selenium

### Copyright disclaimer: Most of the explanations are organized from multiple internet sources for better understanding the tools and concepts. I do not own nor wrote majority portion of the original explanations.

This repository is to help me understand and learn more about Selenium and TestNG.

Content:
* [Selenium](#Selenium)
* [TestNG](#TestNG)
* [Maven](#Maven)


---

# Selenium

### Q: What is Selenium?
 - Selenium is a free, open-source User Interface automation testing tool used to validate web applications across different 
browsers and platforms. It is used exclusively for web-based applications. Selenium is composed of multiple tools. 
It works with all major platforms has support for all major browsers as well. Selenium has integration with popular 
languages like Java, C#, Python, etc.

### Q: Components of Selenium?
 - <h4>Selenium IDE</h4>
    - Selenium IDE is Firefox plugin which gives us the reacord/play back feature of test cases via a GUI. It allows to write 
    a test case and convert this test case to any supporting language.
 - <h4>Selenium RC</h4>
    - Selenium RC was the main Selenium project for a long time before the WebDriver merge brought up Selenium. Selenium
      1 is still actively supported (in maintenance mode). It relies on JavaScript for automation.
 - <h4>Selenium WebDriver</h4>
    - Selenium WebDriver is a browser automation framework that accepts commands and sends them to a browser. It is 
      implemented through a browser-specific driver. It controls the browser by directly communicating with it. This is 
      now used widely over Selenium RC due to its simplicity and functionality.
 - <h4>Selenium Grid</h4>
    - Selenium Grid is a tool used to run tests on different machines against different browsers in parallel. That is, 
      running multiple tests at the same time against different machines running different browsers and operating systems.

### Q: What is Selenium WebDriver Architecture?
1. All Test classes or suites are converted to JSON format as soon as they are being run.
2. All JSON generated in step 1 will be sent to Browser Driver over the HTTP protocol. (Every browser have an independent driver associated with them)
3. Browser Driver communicates with its respective browser and executes the commands by interpreting the JSON which was received.
4. Browser Driver receives a response(s) back from the browser and sends back the result to the client in JSON format.

### Q: How do you invoke a browser?
 - By creating an instance of the specific browser’s WebDriver and calling <code>webDriver.get("url")</code> method on it. 
(Assuming the apporpriate dependencies and the web driver path have been configured successfully.)
```java
WebDriver webDriver = new ChromeDriver();
webDriver.get(“urlToGet”);
```

### Q: Methods of a WebDriver?
 - ```get(String)```
    - It takes a URL as a string and tries to open it. If successful it will open the given link in the current browser 
      window.
 - ```getCurrentUrl()```
    - Returns a string representation of the URL the driver is at.
 - ```getTitle()```
    - Returns the title of the current page.
 - ```close()```
    - Closes the current window. Quits the driver if it was the only window.
 - ```findElement(By by)```
    - Finds the first element in the current page that matches the given identifier.
 - ```findElements(By by)```
    - Finds all elements in the current page that matches the given identifier.
 - ```quit()```
   - Quits the driver and closes all window associated with it.
 - ```getWindowHandle()```
   - It returns a ```String``` representation of the window is in focus by the driver. The value can be used to switch to multiple windows.
 - ```getWindowHandles()```
   - It returns a ```Set<String>``` which can be iterated over to switch between windows.
 - ```manage()```
   - a 
 - ```navigate()```
   - As name suggests, it used it context of going back and/or forward in the browser's history or visited page. It returns
   a ```Navigation``` object which has these methods:
     - ```to(String)```
         - It takes a ```String``` as a URL and loads that url.
     - ```to(URL)```
         - It takes a ```URL``` as a URL and loads that url.
     - ```back()```
         - It takes back the previously visited page, if there is any.
     - ```forward()```
         - It takes the ```webdriver``` to 1 page forward, if there is any.
     - ```refresh()```
         - Refresh the current web page.
 - ```switchTo()```
   - ```alert()``` - Returns an ```Alert``` object, has below methods to work with alerts.
     - ```accept()``` - accepts the alert by clicking <b>OK</b>.
     - ```dismiss()``` - cancel the alert by clicking <b>Cancel</b>.
     - ```getText()``` - returns the displayed text of the alert.
     - ```sendKeys()``` - enters text to the prompt field of the alert box.
   - ```frame(...)``` - frame has overloaded methods to switch to a frame.
   - ```parentFrame()``` - switching to parent frames can be achieved by this method.
   - ```defaultContent()``` - switches the control to the main page.
   - ```window(String)``` - switches the driver control to the given window, if found.

### Q: What is a Locator?
 - A locator is a command that selenium identifies and using that it interacts with elements. Locators are instance of ```By```
   interface in Java.
 - <b>Types of Locators:</b>
    - ```id(String)```: Locating elements on the page using ID is the fastest way to interact with elements since ID are 
      unique. Ex. ```By.id(String)```
    - ```linkText(String)```: It is used to interact with elements (<a> tags). It takes the text that is visible for any
      given link. Ex. ```By.linkText(completeTextOfTheLink)```. The specified text is the exact text that is available on
      the webpage.
    - ```partialLinkText(String)```: It is used to interact with elements (<a> tags). It takes the text that partially matches
      any link on the web page. Ex. ```By.linkText(partialLinkText)```.
    - ```name(String)```: It locates elements on the page using HTML name attribute value given to the function. Ex. ```By.name(string)```
    - ```className(String)```: Class Name locator gives the element which matches the values specified in the HTML attribute
      name "class".
    - ```tagName(String)```: Tag Name locator is used to find the elements matching the specified HTML Tag Name. Ex. ```By.name(string)```
    - ```cssSelector(String)```: CSS Selectors in Selenium are string patterns used to identify an element based on a 
      combination of HTML tag, id, class, attributes, inner text, and child.
    - ```xpath(String)```: XPath is the language used when locating XML nodes. Since HTML can be thought of as an 
      implementation of XML, we can also use XPath in locating HTML elements.
        - Advantage: It can access almost any element, even those without class, name, or id attributes.
        - Disadvantage: It is the most complicated method of identifying elements because of too many rules and 
          considerations.
        - Tools like SelectorsHub, ChroPath, Firebug etc. can automatically generate XPath for elements on the page.

### About XPath and CSS Selector:
 - Xpath and CSS are preferred as locators as others could potentially be dynamic.
 - <b>Absolute and Relative Path:</b>
    - <b>Absolute path:</b> Absolute path means to specify every single node to select a node inside a hierarchical 
      document. It always starts from root node, ```/html```. It is relatively faster than a relative path.
    - <b>Relative path:</b> In Relative XPath expression you can start from the node of your choice.
 - <b>Expression ```/``` and ```//```:</b>
    - A double slash "//" means any descendant node of the current node in the HTML tree which matches the locator.
    - A single slash "/" means a node which is a direct child of the current.
    - ```//div[@id='add']//span[@id=addone']``` will match both:
      ```
        <div id="add">
            <div>
                <span id="addone">
            </div>
        </div>
      
        <div id="add">
           <span id="addone">
        </div>
      ```
    - ```//div[@id='add']/span[@id=addone']``` will match only the second HTML tree.
 - ClassName locators cannot have space(s) in the value.
 - Default Xpath has double quotes inside it but Java would not allow it. So we convert all double quotes to single quotes.
 - Xpath starting with ```/HTML``` is not reliable.


### Select Option:
 - the ```Select``` class provides the implementation of the HTML SELECT tag. A select tag provides the helper methods with 
   selecting and deselecting options.
   ```java
   Select dropDown = new Select(webDriver.findElement(By.id("dropDownLocator")));
   
   dropDown.selectByIndex(2);  // select the 3rd option
   dropDown.selectByVisibleText("displayedText"); // select the option that matches the specified text
   dropDown.selectByValue("value");     // select the option that matches the with the specified value
   dropDown.isMultiple();    // checks if multiple option can be selected, returns boolean
   dropDown.getOptions();   // returns all options of the dropdown as List<WebElement>
   dropDown.getFirstSelectedOption(); // returns the first element from the selected options
   dropDown.deselectAll();  // uncheck all options
   ```

### Q: How to count CheckBoxes in a web page?
 - By calling ```findElements()``` with either ```cssSelector``` or ```XPath```. Ex - 
 ```java
    webDriver.findElements(By.cssSelector("input[type='checkbox']")).size();
   ```

### Q: How to take a Screenshot?
 - By casting the driver object to ```TakeScreenshot``` class and calling ```getScreenshotAs(OutputTye.File)``` which 
   returns a ```File``` object. OutputType is an interface. Screenshot is saved as PNG file, if saved as ```OutputTye.File```.
   It can also be saved as ```byte[]```. Finally, we can move the screenshot file to desired destination. Ex - 
   ```java
    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Path path = Files.move(Paths.get(file.getAbsolutePath()), Paths.get("/Users/hamidurrahman/Downloads/"+file.getName()));
    Assert.assertNotNull(path);
   ```

### Q: Waits in Selenium?
- <b>Implicit Wait:</b> An implicit wait allows driver to listen to the DOM for a certain amount of times to find an element or
  execution of the flow before throwing ```NoSuchElementException```. It is also known as global wait as it is applied to 
  the execution of the test. Ex - 
  ```java
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  ```
  This will tell the driver to wait 5 seconds but if the element is found/visible before 5 seconds then it will continue
  the execution without waiting for 5 seconds.
  
- <b>Explicit Wait:</b> With an explicit wait command, the WebDriver is directed to wait until a certain condition occurs
  before proceeding executing the code and throwing ```NoSuchElementException```. Explicit wait is more intelligent,
  but can only be applied for specified elements where an implicit wait is applied to the whole test. Ex -
  ```java
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("id")));
    element.click();
  ```
- <b>Fluent Wait:</b> FluentWait instance defines the maximum amount of time to wait for a condition, as well as the 
  frequency with which to check the condition.
  ```java
    // Waiting 30 seconds for an element to be present on the page, checking
    // for its presence once every 5 seconds.
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
            return driver.findElement(By.id("foo"));
        }
    });
  ```


### Q: Challenges of Selenium?
1. Cannot test anything besides web browser.
2. Cannot test mobile applications.
3. Limited reporting. (Work around via TestNG)
4. Dynamic Elements.
5. Page load.
6. Pop up windows.
7. Handling captcha.

---

# TestNG
