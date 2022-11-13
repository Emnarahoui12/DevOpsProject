pipeline {
    agent any
	
	
   
	 tools {
        maven '3.8.1'
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
				credentialsId : 'ba06947d-89eb-47f2-9005-584063266420' 
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
		
    stage('Nexus'){
            steps{
                script{
                    def mavenPom = readMavenPom file: 'pom.xml'
                
        nexusArtifactUploader artifacts: [
             [artifactId: 'achat',
                    classifier: '',
                    file: "target/devopsprojet-${mavenPom.version}.jar",
                     type: 'jar'],
            ],  
                credentialsId: 'NEXUS_CRED',
                groupId: 'tn.esprit.rh',
                nexusUrl: '169.254.103.182:8081',
                nexusVersion: 'nexus3',
                protocol: 'http',
                repository: 'TestApp',
                version: "${mavenPom.version}"
            }
        }
        }
        
       
        
 
               
            }
      
        
    }