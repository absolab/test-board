import apis from "commons/apis";
import { BoardDetailResponseInterface, BoardInterface, ResponseResultValue } from "commons/interface";
import { Board, Header } from "components";
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

const Detail = () => {

    const navigate = useNavigate();

    const { bid } = useParams();

    const [name, setName] = useState<string | null>(null);
    const [isLogined, setIsLogined] = useState(false);
    const [data, setData] = useState<BoardInterface>({title: '', content: ''});

    useEffect(() => {

        // 로그인 확인
        setName(sessionStorage.getItem('login'));
        if (name !== null) { setIsLogined(true); }

        // 게시물 정보 불러오기
        if (bid) {
            const numberBid = Number.parseInt(bid);

            const getDetail = async () => {

                const res: BoardDetailResponseInterface = await apis.getDetail(numberBid);
                if (res && res.result === ResponseResultValue.SUCCESS) {
                    setData(res.data.board);
                } else {
                    alert('잠시 후 다시 시도하세요')
                    navigate(-1);
                }
            }

            getDetail();

        } else {
            // 잘못된 bid입니다!
            navigate("/");
        }

    }, [bid, name, navigate]);

    const onEditBtnClickEvent = () => {
        navigate("/edit/" + data.bid);
    }

    const onDeleteBtnClickEvent = async () => {
        const confirmResult = window.confirm('삭제하시겠습니까?')
        if (confirmResult && bid) {
            const numberBid = Number.parseInt(bid);
            const res = await apis.postDeleteWrite(numberBid);
            console.log(res);
            if (res && res.result === ResponseResultValue.SUCCESS) {
                alert('삭제되었습니다');
                navigate('/');
            }
        } else {
            alert('잠시 후 다시 시도하세요');
        }
    }

    const onReturnBtnClickEvent = () => {
        navigate(-1);
    }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
                <Board data={data} setData={setData} readOnly={true}></Board>
                <div className="flex mx-auto">
                    {(name  === data.name)&& <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onEditBtnClickEvent}>수정</button> }
                    {(name  === data.name)&& <button className="mx-1 bg-red-400 py-1 px-3 my-2 rounded hover:bg-red-500" onClick={onDeleteBtnClickEvent}>삭제</button> }
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onReturnBtnClickEvent}>돌아가기</button>
                </div>
            </div>
        </div>
    )
};

export default Detail;

