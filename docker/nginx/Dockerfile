FROM nginx:1.28.1-alpine-slim

COPY ./docker/nginx/nginx.conf /etc/nginx/nginx.conf
COPY ./docker/nginx/default.conf /etc/nginx/conf.d/default.conf
COPY ./docker/nginx/upstream.conf /etc/nginx/conf.d/upstream.conf

COPY ./src/main/resources /var/www/app/static

EXPOSE 80 443

CMD ["nginx", "-g", "daemon off;"]