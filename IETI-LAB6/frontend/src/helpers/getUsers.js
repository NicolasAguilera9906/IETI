

export const getUsers = async () => {
    const url = `http://ietibackendaguilera.centralus.azurecontainer.io:8080/users`;
    const resp = await fetch(url);
    const data = await resp.json();
    console.log(data);

    const users = data.map(user => {
        return {
            id: user.id,
            name : user.name,
            email : user.email,
            password : user.password,
        }
    })

    return users;
}