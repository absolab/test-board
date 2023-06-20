import apis from "commons/apis";
import { BoardDetailResponseInterface, BoardInterface, ResponseResultValue } from "commons/interface";
import { Board, Header } from "components";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Edit = () => {

    const navigate = useNavigate();

    const { bid } = useParams();

    const [isLogined, setIsLogined] = useState(false);
    const [data, setData] = useState<BoardInterface>({title: '', content: ''});

    useEffect(() => {
        // 게시물 정보 불러오기
        if (bid) {
            const numberBid = Number.parseInt(bid);

            const getDetail = async () => {

                const res: BoardDetailResponseInterface = await apis.getDetail(numberBid);
                if (res.result === ResponseResultValue.SUCCESS) {
                    setData(res.data.board);
                    console.log(res.data);
                } else {
                    // 잘못된 bid입니다!
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

        const res = await apis.postEditWrite(numberBid, data.title, data.content);
        if (res.result === ResponseResultValue.SUCCESS) {
            navigate("/");
        } else {
            console.log('수정 실패!');
        }
    }

    const onReturnBtnClickEvent = () => {
        navigate(-1);
    }

    return (
        data ? 
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
                <Board data={data} setData={setData} readOnly={false}></Board>
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