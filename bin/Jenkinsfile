pipeline{
    agent any
	 environment {
            DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }
    
    tools {
        maven 'M2_HOME'
    }
    stages {
      
        
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: 'iheb', url: 'https://github.com/MohamedHbibBenHlima/DevOps-5TWIN1.git'
               
            }
        }
        stage('Clean'){
            steps {
                sh 'mvn clean '
            }
            
        }
	
	    
        stage('Compile'){
            steps {
                sh 'mvn compile -DskipTests'
            }
            
        }
        
        
         stage('UNIT test'){
            steps{
                sh 'mvn test'
            }
        }
	
         
          stage('Docker build')
        {
            steps {
                 sh 'docker build -t ihebsg/achat  .'
            }
        }
        stage('Docker login')
        {
            steps {
                sh 'echo $dockerhub_PSW | docker login -u ihebsg -p dckr_pat_c9uEUxgEqE-CAs9UJRV_6QUqjAo'
            }    
       
        }
      stage('Push') {

			steps {
				sh 'docker push ihebsg/achat'
			}
		}
       stage('DockerCompose') {
        
                       steps {
                                sh 'cd /var/lib/jenkins/workspace/ihebPipeline'
								sh 'docker-compose up -d'
                        }
                          
        }
	
        stage('NEXUS'){
         
             steps{
                 sh 'mvn deploy '
             }
                 
         }
        
        
        
        
        
    
        stage('SonarQube analysis'){
            steps{
                script{
                    withSonarQubeEnv(credentialsId:'sonar-api'){
                        sh 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
	 
        
        
       
}
}
