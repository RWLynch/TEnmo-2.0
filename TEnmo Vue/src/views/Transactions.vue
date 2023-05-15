<script setup>

</script>

<template>
  <div>
    <div class="buttons">
        <img class="balance" src="src\assets\Balance Icon.png" alt="balance">
        <img class="send-money" src="src\assets\Send Money Icon.png" alt="send money">
        <img class="request" src="src\assets\Request Icon.png" alt="request money">
        <img class="trading" src="src\assets\Trading Icon.png" alt="trading">
    </div>
  </div>
</template>

<style>

.send-money:hover,
.balance:hover,
.request:hover,
.trading:hover {
  box-shadow: rgba(0, 0, 0, 0.3) 8px 8px 8px 0;
  transform: translate3d(0, 2px, 0);
}

.buttons {
  display: grid;
  grid-template-areas:
  "send-money balance"
  "request trading";
}

.send-money {
  grid-area: send-money;
}

.balance {
  grid-area: balance;
}

.request {
  grid-area: request;
}

.trading {
  grid-area: trading;
}
</style>