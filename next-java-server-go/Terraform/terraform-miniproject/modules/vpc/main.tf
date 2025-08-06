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

resource "aws_vpc" "main" {
  cidr_block = var.cidr_block
}

resource "aws_subnet" "public" {
  vpc_id = aws_vpc.main.id
  cidr_block = cidrsubnet(var.cidr_block,8,0)
  availability_zone = "ap-northeast-2a"
  map_public_ip_on_launch = true
  tags = {
    Name="go-vpc"
  }
}

resource "aws_security_group" "web_sg" {
  name = "web-sg"
  description = "Allow HTTP"
  vpc_id = aws_vpc.main.id
  tags = {
    Name="go-sg"
  }

  ingress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}