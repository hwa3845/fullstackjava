FROM node:lts-alpine
# ENV NODE_ENV=production
WORKDIR /usr/src/app
# COPY ["package.json", "package-lock.json*", "npm-shrinkwrap.json*", "./"]
# RUN npm install --production --silent && mv node_modules ../
RUN npm install -g serve
COPY ./build .
EXPOSE 3000
RUN chown -R node /usr/src/app
USER node
# CMD ["npm", "start"]
CMD ["serve", "."]
