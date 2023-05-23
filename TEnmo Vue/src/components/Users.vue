<script>
import { useStore } from '../stores/authStore'
import UserService from "../services/UserService";

export default {
    name: "users-list",
    data() {
        return {
            users: [],
            user: {
                userId: "",
                username: "",
                firstName: "",
                lastName: "",
                profilePic: ""
            }
        }
    },
    created() {
        UserService.getUsersList().then((response) => {
            this.users = response.data;
        })
    }
}

</script>

<template>
    <div>
        <h1>Pick a user</h1>
        <div>
            <table>
                <thead> <!-- optional tag -->
                    <tr>
                        <th>Name</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Profile Photo</th>
                    </tr>
                </thead>
                <tbody> <!-- optional tag -->
                    <tr v-for="user in users" :key="user.userId">
                        <td class="user-name">{{user.username}}</td>
                        <td class="first-name">{{user.firstName}}</td>
                        <td class="last-name">{{user.lastName}}</td>
                        <td class="profile-pic">{{user.profilePic}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<style></style>