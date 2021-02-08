# Testerra Skeletons

Contains project skeletons for the Testerra Test Automation Framework.

## Prerequisites

### Setup for existing Selenium environment

You need to configure your existing Selenium environement in `test.properties`
```shell script
# Selenium environment
tt.selenium.server.url=http://[selenium-host]:[port]
#tt.webdriver.mode=local
```

### Or setup local Selenium environment

Install the following components into your environment.

#### On Windows using Chocolately
```shell script
choco install chromium chromedriver
```

#### On Debian/Ubuntu
```shell script
apt-get install chromium-browser chromium-chromedriver
```

#### On MacOSX (tdb)
```shell script
brew install
```

## Run the tests (tbd)
```shell script
gradle test -Peverything
```

## View test results
Open `test-report/report-ng` in an evergreen browser.
