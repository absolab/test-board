import axios from "axios";

const config = () => {

    return {
        url: 'http://localhost',
        port: 8080,
    }
}

const apis = {
    postLogin: async (id:string, pwd:string) => {

        const data = new FormData();
        data.append('id', id);
        data.append('pwd', pwd);

        try {
            let res = await axios.post(config().url + ':' + config().port + '/users/login', data);
            return res.data;
        } catch (err) {
            console.log(err);
        }
    }

}

export default apis;