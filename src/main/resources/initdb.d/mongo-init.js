db.createUser(
    {
        user: "test",
        pwd: "test",
        roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
    }
)