FROM node AS build

COPY . .
RUN npm install
RUN npm test \
  && npm run-script build

FROM node

COPY dist/ .
RUN npm install -g http-server
EXPOSE 8080
CMD [ "http-server", "." ]