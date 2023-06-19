import axios from "axios";

const config = () => {

    return {
        url: 'http://localhost',
        port: 8080,
        config: { withCredentials: true }
    }
}

const apis = {

    // 로그인
    postLogin: async (id:string, pwd:string) => {

        const data = new FormData();
        data.append('id', id);
        data.append('pwd', pwd);

        try {
            let res = await axios.post(config().url + ':' + config().port + '/user/login', data, config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    // 로그인 확인
    getIsLogined: async () => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/user/login', config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    postLogout: async () => {
        try {
            const res = await axios.post(config().url + ':' + config().port + '/user/logout', null, config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    // 글 목록
    getList: async () => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/board/list', config().config);
            return res.data;
        } catch (_) { console.log(_) }
    },

    // 글 정보
    getDetail: async (bid: number) => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/board/detail/' + bid, config().config);
            return res.data;
        } catch (_) { console.log(_) }
    },

    // 글 등록
    postWrite: async (title:string, content:string) => {

        const data = new FormData();
        data.append('title', title);
        data.append('content', content);

        try {
            const res = await axios.post(config().url + ':' + config().port + '/board/write', data, config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    // 글 수정
    postEditWrite: async (title:string, content:string) => {

        const data = new FormData();
        data.append('title', title);
        data.append('content', content);

        try {
            const res = await axios.post(config().url + ':' + config().port + '/board/write', data, config().config);
            return res.data;
        } catch (_) { console.log(_) }
    }
}

export default apis;