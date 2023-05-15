<script setup></script>

<template>
  <div>
    <div class="buttons">
      
      <RouterLink class="balance" to="balance">
        <img class="balance" src="src\assets\Balance Icon.png" alt="balance" />
      </RouterLink>

      <RouterLink class="send-money" to="#">
        <img class="send-money" src="src\assets\Send Money Icon.png" alt="send money" />
      </RouterLink>
      
      <RouterLink class="request" to="#">
        <img class="request" src="src\assets\Request Icon.png" alt="request money" />
      </RouterLink>


      <RouterLink class="trading" to="#">
        <img class="trading" src="src\assets\Trading Icon.png" alt="trading" />
      </RouterLink>

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
  margin: 0 auto;
  padding: 50px;
  display: grid;
  max-width: 400px;
  max-height: 400px;
  row-gap: 20px;
  column-gap: 20px;
  grid-template-areas:
    'balance send-money'
    'request trading';
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

button {
  border-style: none;
  color: none;
  background-color: transparent;
}
</style>
