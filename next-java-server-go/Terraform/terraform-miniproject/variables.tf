variable "ami_id" {
  type = string
  default = "ami-04301af73b49c0af2"
}

variable "instance_type" {
  description = "EC2 인스턴스 타입"
  default = "t2.micro"
}