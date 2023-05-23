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
                    <tr>
                        <td>C</td>
                        <td>1972</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<style></style>