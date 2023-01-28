<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <style>
       
        #modal {
            display:none;

            position:relative;
            width:100%;
            height:100%;
            z-index:1;
        }

        #modal h2 {
        margin:0;   
        }

        #modal button {
        display:inline-block;
        width:30px;
        margin-left:calc(100% - 100px - 10px);
        }

        #modal .modal_content {
        width: 600px;
        margin:100px auto;
        padding:20px 20px;
        background:#fff;
        border:2px solid #666;
        }

        #modal .modal_layer {
        position:fixed;
        top:0;
        left:0;
        width:100%;
        height:100%;
        background:rgba(0, 0, 0, 0.5);
        z-index:-1;
        }   

        #header-1{width:500px; height:30px;}
        #header-1{position:relative;}
        #search-form>div{
            height:100%;
            float:left;
        }
        #search-text{width:80%;}
        #search-btn{width:20%;}

        #search-form input{
            width:100%; 
            height:100%;
            box-sizing: border-box;
        }

    </style>
</head>
<body>
	 <div id="root">
    
        <button type="button" id="modal_opne_btn">검색</button>
        
    </div>

    <div id="modal">
    
        <div class="modal_content">
            <button type="button" id="modal_close_btn">X</button>
            
            <div id="header-1">
                <form action="" id="search-form">
                    <div id="search-text">
                        <input type="text" id="productInput" name="keyword" placeholder="브랜드, 모델명 등" onkeyup="search(this);">
                    </div>
                    <div id="search-btn">
                        <input type="submit" value="검색">
                    </div>
                    <div id="productlist"></div>
                    <h5 id="selected"></h5>
                </form>
                
                
            </div>
        
            <div  class="p-cate">
                <h4>카테고리</h4>
                <table>
                    <tr>
                        <td><img src="resources/s_sample.jpg" alt="" width=100px></td>
                        <td><img src="resources/s_sample.jpg" alt="" width=100px></td>
                        <td><img src="resources/s_sample.jpg" alt="" width=100px></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;신발</td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;지갑</td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;테크</td>
                    </tr>
                </table>
            </div>
        
            <br><br>
            
            <div class="b-popular">
                <h4>인기브랜드</h4>
                <table>
                    <tr>
                        <td><img src="resources/s_sample.jpg" alt="" width=100px></td>
                        <td><img src="resources/s_sample.jpg" alt="" width=100px></td>
                        <td><img src="resources/s_sample.jpg" alt="" width=100px></td>
                    </tr>
                    <tr>
                        <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nike</td>
                        <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jordan</td>
                        <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UGG</td>
                    </tr>
                </table>
            </div>
        
            <br><br>
            <div class="p-recent">
                <span>최근 본 상품</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><u>지우기</u></span>
                <div>
                    <img src="resources/s_sample.jpg" width=100px>
                    <p>브랜드명</p>
                    <p>영문상품명</p>
                </div>        
        
        
            </div>
        
        </div>
    
        <div class="modal_layer"></div>
    </div>

    <script>
            
        $("#modal_opne_btn").click(function(){
            $("#modal").attr("style", "display:block");
        });
    
        $("#modal_close_btn").click(function(){
            $("#modal").attr("style", "display:none");
        });      

    </script>
    
    <!-- 검색 -->
    <script>
		/*
    	function search(target){
    		$.ajax({
                type:'GET',
                dataType:'JSON',
                url:"/scale/plist.pd",
                error:function(err){
                    alert("없음");
                },
                success:function(data){
                    var checkWord = $("#productInput").val();
                    var productlist = $("#productlist");

                    productlist.empty();
                    data.forEach((product)=>{
                        if(product['name'].includes(checkWord)){
                            productlist.append(<span style="cursor:pointer;" onclick="select(this);"> ${product['name']} </span> );
                        }
                    })
                }
            })
    	}

        function select(target){
            const selected = document.getElementById("selected");
            selected.innerText = target.innerText;
        }
        */
    
    </script>
    
</body>
</html>