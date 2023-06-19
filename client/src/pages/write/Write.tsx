import apis from "commons/apis";
import { BoardInterface, ResponseInterface, ResponseResultValue } from "commons/interface";
import { Header, Board } from "components";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const Write = () => {

    const navigate = useNavigate();
    const [isLogined, setIsLogined] = useState(false);
    const [data, setData] = useState<BoardInterface>({title:'', content: ''});

    useEffect(() => {
        const name = sessionStorage.getItem('login');
        if (name !== null) {
            setIsLogined(true);
            data.name = name;
            data.crtnDate = new Date().toISOString()
        } else {
            alert('로그인 정보가 없습니다');
            navigate(-1);
        }
    }, [])

    const onWriteBtnClickEvent = async () => {

        if (!data.title) { console.log('제목을 입력 해 주세요!'); return; }
        if (!data.content) { console.log('내용을 입력 해 주세요!'); return; }

        const res: ResponseInterface = await apis.postWrite(data.title, data.content);
        if (res.result === ResponseResultValue.SUCCESS) {// 성공!
            navigate("/");
        } else { // 실패!
            navigate("/");
        }
    }

    const onReturnBtnClickEvent = () => { navigate(-1); }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">글작성</div>
                <Board data={data} setData={setData} readOnly={false}></Board>
                <div className="flex mx-auto">
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onWriteBtnClickEvent}>등록</button>
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onReturnBtnClickEvent}>취소</button>
                </div>
            </div>
        </div>
    )
}

export default Write;