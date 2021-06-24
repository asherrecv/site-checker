# Stage 1

FROM node:14-alpine as build

RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build --prod


# Stage 2

FROM nginx:latest

COPY --from=build /app/dist/site-checker /usr/share/nginx/html
EXPOSE 80
