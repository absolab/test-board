import apis from "commons/apis";
import { BoardDetailResponseInterface, BoardInterface, FileInterface, ResponseResultValue } from "commons/interface";
import { Board, Header } from "components";
import { ChangeEvent, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Edit = () => {

    const navigate = useNavigate();

    const { bid } = useParams();

    const [isLogined, setIsLogined] = useState(false);
    const [data, setData] = useState<BoardInterface>({title: '', content: ''});
    const [deleted, setDeleted] = useState<Array<number>>([]);
    const [files, setFiles] = useState<Array<File>>([]);
    const [existFiles, setExistFiles] = useState<Array<FileInterface>>([]);


    useEffect(() => {
        // 게시물 정보 불러오기
        if (bid) {
            const numberBid = Number.parseInt(bid);

            const getDetail = async () => {

                const res: BoardDetailResponseInterface = await apis.getDetail(numberBid);
                if (res.result === ResponseResultValue.SUCCESS) {
                    setData(res.data.board);
                    if (res.data.files) { setExistFiles(res.data.files); }
                } else {
                    alert('잠시 후 다시 시도하세요')
                }
            }

            getDetail();

        } else {
            // 잘못된 bid입니다!
            navigate("/");
        }

        // 로그인 확인
        const name = sessionStorage.getItem('login');
        if (name !== null) { setIsLogined(true); }
        else {
            alert('로그인 정보가 없습니다.')
            navigate(-1);
        }

    }, [bid, navigate])

    const onSaveBtnClickEvent = async () => {

        if (!data.title) { console.log('제목을 입력 해 주세요!'); return; }
        if (!data.content) { console.log('내용을 입력 해 주세요!'); return; }

        const numberBid = Number.parseInt(bid!);

        const res = await apis.postEditWrite(numberBid, data.title, data.content, files, deleted);
        if (res.result === ResponseResultValue.SUCCESS) {
            navigate("/");
        } else {
            console.log('수정 실패!');
        }
    }

    const onReturnBtnClickEvent = () => {
        navigate(-1);
    }

    const ExistFiles = existFiles.map((item, idx) => {
        return ( <div className="m-1 px-1 border-blue-300 border-2 cursor-pointer hover:border-blue-400" key={idx} onClick={() => {onExistFileClickEvent(item.aid)}}>{item.name}</div> );
    })
    const Files = files.map(item => {
        return ( <div className="m-1 px-1 border-red-300 border-2">{item.name}</div> );
    })

    const onExistFileClickEvent = (aid: number|undefined) => {

        if (aid) { setDeleted([ ...deleted, aid]); }
        setExistFiles(existFiles.filter((item) => item.aid !== aid));
    }

    const onFileInputChangeEvent = (e: ChangeEvent<HTMLInputElement>) => {
        if (e.target.files) {
            const arr = Array<File>();
            for (const idx in e.target.files) {
                arr.push(e.target.files[idx]);
            }
            arr.pop();
            arr.pop();  // 좀 더 좋은 방법을 강구
            setFiles(arr);
        }
    }

    return (
        data ? 
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">글수정</div>
                <Board data={data} setData={setData} readOnly={false}></Board>
                <div className="m-1">
                    <input type="file" multiple onChange={onFileInputChangeEvent}/>
                </div>
                <div className="flex items-center">
                    <div className="m-1">첨부:</div>
                    {ExistFiles}
                    {Files}
                </div>
                <div className="flex mx-auto">
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onSaveBtnClickEvent}>저장</button>
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onReturnBtnClickEvent}>돌아가기</button>
                </div>
            </div>
        </div>
        :
        <div></div>
    )
}

export default Edit;