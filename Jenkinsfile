pipeline {
    agent any

    stages {
           stage("MAVEN Cleaning Phase") {
      
      steps {
        echo 'cleaning the application ...'
        sh "mvn clean"
      }
    }
  
    stage("MAVEN Compiling Phase") {
      
      steps {
        echo 'compiling the application ...'
        sh "mvn compiler:compile"
      }
    }
    stage("JUnit Testing Phase") {
      
      steps {
        echo 'unitary testing with JUnit and Mockito...'
        sh "mvn test"
      }
    }
      stage("SonarQube Analysis Phase") {
      
        steps {
        sh "mvn sonar:sonar \
  -Dsonar.projectKey=springproject \
  -Dsonar.host.url=http://192.168.122.1:9000 \
  -Dsonar.login=bd530499e23dfcabb568d334f009ec81f18bd321"
      }
    }
        stage("Nexus Deployement Phase") {
            steps { 
                sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
            }
        }
    
    }
}
