Plugins
==

maven-surefire-plugin
--
runs tests (*Test.java, ...) on mvn test, and later steps (integration-test, verify)

maven maven-failsafe-plugin
--
runs integration tests (*IT.java,...) on mvn integration-test and later steps (i.e verify)  
plugin needs additional configuration (https://mincong.io/2018/10/04/maven-failsafe-plugin-understanding)

Links
==
https://mincong.io/about/


Test Double
==
https://martinfowler.com/bliki/TestDouble.html  


TDD: Test Styles
===
https://blog.devgenius.io/detroit-and-london-schools-of-test-driven-development-3d2f8dca71e5

Testing state (Classicist, Detroit style)  
--
Test-driven development - Kent Beck  
verify outcome  
stubbing could be enough  
test setup grows larger
Unit - class / method/

test

Testing behavior (Mockist, London style)  
--
Steve Freeman
mocking  
test setup smaller / context limited
