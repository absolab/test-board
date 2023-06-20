import apis from "commons/apis";
import { BoardInterface, FileInterface, ResponseInterface, ResponseResultValue } from "commons/interface";
import { Header, Board } from "components";
import { ChangeEvent, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const Write = () => {

    const navigate = useNavigate();
    const [isLogined, setIsLogined] = useState(false);
    const [data, setData] = useState<BoardInterface>({title:'', content: ''});
    const [files, setFiles] = useState<Array<File>>([]);

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

        const res: ResponseInterface = await apis.postWrite(data.title, data.content, files);
        if (res.result === ResponseResultValue.SUCCESS) {// 성공!
            navigate("/");
        } else { // 실패!
            navigate("/");
        }
    }

    const onReturnBtnClickEvent = () => { navigate(-1); }

    const Files = files.map(item => {
        return ( <div className="m-1 px-1 border-blue-300 border-2 cursor-pointer hover:border-blue-400">{item.name}</div> );
    })

    const onFileInputChangeEvent = (e: ChangeEvent<HTMLInputElement>) => {
        if (e.target.files) {
            const arr = Array<File>();
            for (const idx in e.target.files) {
                arr.push(e.target.files[idx]);
            }
            arr.pop();
            arr.pop();
            setFiles(arr);
            console.log(arr);
        }
    }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">글작성</div>
                <Board data={data} setData={setData} readOnly={false}></Board>
                <div className="m-1">
                    <input type="file" multiple onChange={onFileInputChangeEvent}/>
                </div>
                <div className="flex items-center">
                    <div className="m-1">첨부</div>
                    {Files}
                </div>
                <div className="flex mx-auto">
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onWriteBtnClickEvent}>등록</button>
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onReturnBtnClickEvent}>취소</button>
                </div>
            </div>
        </div>
    )
}

export default Write;