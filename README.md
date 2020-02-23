# quarkus-smallrye-eventbus

## vertx-producer

Send three different events (`priceAddress1`, `priceAddress2` and `priceAddress3`) to eventbus running in cluster

run: mvn quarkus:dev

## vertx-consumer

Handle all three events, however `priceAddress3` does not work

run: mvn quarkus:dev -Ddebug=5006
