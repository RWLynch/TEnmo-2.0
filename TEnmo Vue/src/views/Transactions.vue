<script setup></script>

<template>
  <div>
    <div class="buttons">
      
      <RouterLink class="balance" to="balance">
        <img class="balance" src="src\assets\Balance Button.png" alt="balance" />
      </RouterLink>

      <RouterLink class="transfer" to="transfer">
        <img class="transfer" src="src\assets\Pay and Request.png" alt="transfer" />
      </RouterLink>

      <RouterLink class="trading" to="#">
        <img class="trading" src="src\assets\Trading Button.png" alt="trading" />
      </RouterLink>

    </div>
  </div>
</template>

<style>
.transfer:hover,
.balance:hover,
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
    'balance transfer trading'
}

.transfer {
  grid-area: transfer;
}

.balance {
  grid-area: balance;
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
