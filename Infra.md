**Standard Pipeline Repository for Java**

https://github.com/nithinkm8055/Utrecht-DevOps-Java.git

**Connect to AWS Server**

*ssh devopsadmin@35.180.103.243*  [Supply password on prompt]

*Install Docker-cli and daemon on machine*

1) Log into your system as a user with sudo privileges.
2) Update your system: *sudo yum update -y*.
3) Add the yum repo (use the code below for both RHEL 7 and CentOS 7):
 $ sudo cat <<EOF>/etc/yum.repos.d/docker.repo
 [dockerrepo]
 name=Docker Repository
 baseurl=https://yum.dockerproject.org/repo/main/centos/7/
 enabled=1
 gpgcheck=1
 gpgkey=https://yum.dockerproject.org/gpg
 EOF

4) Install Docker:
 sudo yum install docker-engine -y

5) Start Docker:
 sudo service docker start

6) Verify Docker:
 sudo docker run hello-world



**Start Jenkins Server**
1) Login to the machine with sudo privileges
2) locate jenkins.war
    Start Jenkins server
    java -jar jenkins.war


**Start Sonarqube Server**
1) Install docker
2) docker container run -d -p 9000:9000 sonarqube:lts