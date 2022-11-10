pipeline {
    agent any
	
	
    tools {
        maven 'Maven 3.8'
    }
	
	
    stages {
        
        stage('Maven version') {
            steps {
                sh 'mvn --version'
            }
        }
		
		
        stage('Git Code') {
            steps {
                git branch: 'mariem', 
				url: 'https://github.com/Emnarahoui12/DevOpsProject',
				credentialsId : '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' 
            }
        }
		
		
        stage('BUILD') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
            
        }
        
        stage('MVN SONARQUBE') {
             steps {
        withSonarQubeEnv(installationName: 'sonarqube1') { 
          sh 'mvn sonar:sonar'
        }
      }
    }
    
       
        
 
               
            }
      
        
    }
}