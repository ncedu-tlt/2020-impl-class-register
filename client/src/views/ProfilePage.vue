<template>
  <div class="profile__wrapper">
    <h3>Profile Page</h3>
    <ProfileDetailsComponent :name="'Ivan'" :last-name="'Ivanov'" :age="25"/>
  </div>
</template>

<script>
import ProfileDetailsComponent from "@/components/ProfileDetailsComponent";
export default {
  name: "ProfilePage",
  components: {ProfileDetailsComponent}
}
</script>

<style scoped lang="less">

</style>
