# Yellow Pepper Challenge By Juan Ochoa

##This project use maven to dependency management



Use "mvn install" to download all the dependences

##Execution with TESTNG

In a command prompt you can use de next commands


set projectLocation=<Project Path>

cd <Project Path>

set classpath=<Project Path>\src\test\java\YellowPepperApi\testcases\TestPet; <Project Path>\YellowPepperChallengeJuanOchoa\lib\*

java org.testng.TestNG <Project Path>\Suite.xml


Note: if you use intellij to review you can execute with right click and play from TestPet Class or Suite.xml
