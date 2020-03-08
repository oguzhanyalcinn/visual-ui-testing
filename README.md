# AI-Powered Visual UI and Intelligent Functional Testing for Websites

## General Information

Website: [https://www.zalando.nl](https://www.zalando.nl/)

Language: Java

Build Tool: Maven

Automation Tools: Applitools Eyes & Selenium

:warning: Do not forget to add your api key into test.properties file to execute the test!

## How does it work?

In my sample test, I am searching for the 'Hoodie' on Zalando. After first run, the test case will be passed and the image
will be saved as baseline image on the Applitools Dashboard. You can see the dashboard below.

[![1.png](https://i.postimg.cc/SsvLd873/1.png)](https://postimg.cc/phKnXmSJ)

After the first test, change the product name (I've changed as 'Pullover') and run again. This time, the test case will be failed
and you will see the failure image on the dashboard. Applitools is comparing baseline image with the new image. You can see
the differences clearly, because the Eyes highlights the different parts. As you can see below, search bar, headline, amount
of the product and images have been highlighted.

[![Screenshot-2020-03-07-at-23-08-33.png](https://i.postimg.cc/T3M9BVMX/Screenshot-2020-03-07-at-23-08-33.png)](https://postimg.cc/PPyYw856)

Happy Testing!
