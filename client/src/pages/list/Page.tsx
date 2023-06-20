import apis from "commons/apis";
import { PageCountResponseInterface, ResponseResultValue } from "commons/interface";
import { useEffect, useState } from "react";

const Page:React.FC<{currentPageNum:number, setCurrentPageNum:(pageNum:number)=>void}> = ({currentPageNum, setCurrentPageNum}) => {

    const [pageCount, setPageCount] = useState<number>(1);

    useEffect(() => {
        const getPageCount = async () => {
            const res:PageCountResponseInterface = await apis.getPageCount();
            if (res && res.result === ResponseResultValue.SUCCESS) {
                setPageCount(res.data);
            }
        }

        getPageCount();
    });

    const onClickPageButton = (num:number) => {
        setCurrentPageNum(num);
    }

    const PageButton:React.FC<{num:number}> = ({num}) => {
        return (
            <div className={"text-sm m-1 cursor-pointer" + (num === currentPageNum + 1?" font-bold":"")} onClick={() => onClickPageButton(num - 1)}>
                {num}
            </div>
        )
    }

    // 5개만 보이게끔 수정, Num-1 너무 보기 싫다
    const PageButtons = Array.from({ length: pageCount }, (_, index) => index + 1).map((pageNumber) => (
        <PageButton key={pageNumber} num={pageNumber} />
    ));

    return (
        <div className="flex border-b-2 border-lime-400 justify-center">
            <div className="text-sm m-1 cursor-pointer" onClick={() => onClickPageButton(0)}>{"<"}</div>
            {PageButtons}
            <div className="text-sm m-1 cursor-pointer" onClick={() => onClickPageButton(pageCount - 1)}>{">"}</div>
        </div>
    );
}

export default Page;