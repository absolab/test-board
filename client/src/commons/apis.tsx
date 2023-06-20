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

    // 로그아웃
    postLogout: async () => {
        try {
            const res = await axios.post(config().url + ':' + config().port + '/user/logout', null, config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    getPageCount: async () => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/board/page', config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    // 글 목록
    getList: async (pageNumber:number) => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/board/list', {params: {pageNumber: pageNumber}});
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
    postWrite: async (title:string, content:string, files:Array<File>) => {

        const data = new FormData();
        data.append('title', title);
        data.append('content', content);
        for (const idx in files) {
            data.append('files', files[idx]);
        }

        try {
            const res = await axios.post(config().url + ':' + config().port + '/board/write', data, config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    // 글 수정
    postEditWrite: async (bid:number, title:string, content:string) => {

        const data = new FormData();
        data.append('bid', bid.toString());
        data.append('title', title);
        data.append('content', content);
        // for (const item in files) {
        //     data.append('files', item);
        // }
        try {
            const res = await axios.post(config().url + ':' + config().port + '/board/edit', data, config().config);
            return res.data;
        } catch (_) { console.log(_) }
    },

    // 글 삭제
    postDeleteWrite: async (bid:number) => {

        const data = new FormData();
        data.append('bid', bid.toString());

        try {
            const res = await axios.post(config().url + ':' + config().port + '/board/delete', data, config().config);
            return res.data;
        } catch (_) { console.log(_); }
    },

    // 파일 다운로드
    getDownloadFile: async (aid:number) => {
        try {
            const res = await axios.get(config().url + ':' + config().port + '/upload/download/' + aid, {responseType:'blob'});
            console.log(res);
            return res.data;
        } catch (_) { console.log(_) }
    }
}

export default apis;