# quarkus-smallrye-eventbus

## vertx-producer

Send tree different events (`priceAddress1`, `priceAddress2` and `priceAddress3`) to eventbus running in cluster

run: mvn quarkus:dev

## vertx-consumer

Try to handle all tree events, however `priceAddress3` does not work

run: mvn quarkus:dev -Ddebug=5006
