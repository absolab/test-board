import apis from "commons/apis";
import { BoardDetailResponseInterface, BoardInterface, ResponseResultValue } from "commons/interface";
import { Board, Header } from "components";
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

const Detail = () => {

    const navigate = useNavigate();

    const { bid } = useParams();

    const [item, setItem] = useState<BoardInterface>({title: '', content: ''});
    const [isLogined, setIsLogined] = useState(false);

    useEffect(() => {

        // 게시물 정보 불러오기
        if (bid) {
            const numberBid = Number.parseInt(bid);

            const getDetail = async () => {

                const res: BoardDetailResponseInterface = await apis.getDetail(numberBid);
                if (res.result === ResponseResultValue.SUCCESS) {
                    setItem(res.data);
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

    }, [bid, navigate]);

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
                <Board data={item} readOnly={true}></Board>
            </div>
        </div>
    )
};

export default Detail;

