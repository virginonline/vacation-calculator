# windows boilerplate
ifeq ($(OS),Windows_NT)
    SHELL := pwsh.exe
else
   SHELL := pwsh
endif
.SHELLFLAGS := -NoProfile -Command

IMAGE_NAME :=virginonline/vacation-calculator
IMAGE_TAG :=latest


image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

run:
	docker run -p 8080:8080 $(IMAGE_NAME):$(IMAGE_TAG)

default:
	cat ./Makefile
dist:
	./mvnw clean package

test:
	./mvnw test