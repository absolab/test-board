import axios from "axios";

const config = () => {

    return {
        url: 'http://localhost',
        port: 8080,
        config: { withCredentials: true }
    }
}

const apis = {
    postLogin: async (id:string, pwd:string) => {

        const data = new FormData();
        data.append('id', id);
        data.append('pwd', pwd);

        try {
            let res = await axios.post(config().url + ':' + config().port + '/users/login', data, config().config);
            return res.data;
        } catch (_) { }
    },

    isLogined: async () => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/users/login', config().config);
            return res.data
        } catch (_) { }
    }

}

export default apis;