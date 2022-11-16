pipeline {
    agent any
 

    stages {
        stage('Git') {
            steps {
            
                git branch: 'nasri', url: 'https://github.com/Emnarahoui12/DevOpsProject.git',
                credentialsId :'2a60d735-a591-4cd4-a60d-1d8f57e1d47a'
                
            }

        
        }
        stage('Maven Package'){
            steps {
                sh " mvn -version "
                sh " java -version "
                sh " mvn package -e "
            }
        }
        
        stage("Maven Clean"){
            steps {
                sh " mvn clean -e "
                
            }
        }

         stage("Maven Compile"){
            steps {
                sh " mvn compile -e "
                
            }
        }

        stage("Maven Install"){
            steps {
                sh " mvn install "
                
            }
        }
                stage("Sonar") {
            steps {
                sh " mvn sonar:sonar \
  -Dsonar.projectKey=devops \
  -Dsonar.host.url=http://192.168.56.2:9000 \
  -Dsonar.login=637ec6839361dea1b6fb67959d83bbfe5b4c5f64 "
            }
         }
         stage("Publish to nexus") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    
                    if(artifactExists) {
                        
                        nexusArtifactUploader(
                            nexusVersion: "nexus3",
                            protocol: "http",
                            nexusUrl: "192.168.56.2:8081",
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: "maven-releases",
                            credentialsId: "381f1e35-c107-458d-96ce-9cb731882664",
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],

                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );

                    } else {
                        error "*** File could not be found";
                    }
                }
            }
        }
         stage("Build Docker image") {
          steps{
              script {
                  pom = readMavenPom file: "pom.xml";
                sh "docker build -t mednsi/devopsspringboot:${pom.version} ."
          }
          }
        }
 stage("Publish image") {
          steps{
              script {
                  pom = readMavenPom file: "pom.xml";
                  withCredentials([string(credentialsId: '72ab3782-b868-45c7-843e-154510f00fbd', variable: 'dockerHub')])  {
                      sh 'docker login -u mednsi -p ${dockerHub}'
                  }
                      sh "docker push mednsi/devopsspringboot:latest"
               }
            }
         }
              stage('Docker Compose') {
                 steps {
		      
                      sh 'docker-compose up -d --build'
                   }
              }
	
    }
	post {
		always {

		    emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
			to: 'mohammed.nasri@esprit.tn',
			subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"

		}
        }
        }