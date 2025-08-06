terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.81.0"
    }
  }
}
provider "aws" {
  region = "ap-northeast-2"
}



module "vpc" {
  source = "./modules/vpc"
}

resource "aws_instance" "web" {
  ami = var.ami_id
  instance_type = var.instance_type
  subnet_id = module.vpc.public_subnet_id
  vpc_security_group_ids = [module.vpc.web_sg_id]
  key_name = "next-dev-key"

  tags = {
    Name = "go-ec2"
  }
}
output "public_ip" {
  value = aws_instance.web.public_ip
}