<script>
import TransactionService from '../services/TransactionService';
import AuthService from '../services/AuthService'

export default {


methods: {

    currentUserId(){
        AuthService.getCurrentUser();
        return user.userId;
    },
    getBalance(userId){
       TransactionService.getBalance(userId) 
    }
    
}
}

</script>

<template>

</template>

<style>

</style>