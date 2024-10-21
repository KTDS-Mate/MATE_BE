<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>받은메세지</title>
    <link rel="stylesheet" type="text/css" href="/css/receive_message.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/common.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>

<body>
    <div class="grid">
        <      <!--  -->
        <div class="header">
            <!-- 헤더 공통파일 -->
            <jsp:include page="../header.jsp"></jsp:include>
        </div>
        <!--  -->
        <div class="content">
            <div class="content-grid">
                <div class="empty"></div>
                <div class="message-side-bar">

                    <ul class="list">
                        <li>보낸 메세지</li>
                        <li>받은 메세지</li>
                        <li>메세지 작성</li>
                    </ul>
                </div>
                <div class="check-box-area">
                    <img src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fpng.pngtree.com%2Fpng-vector%2F20190721%2Fourlarge%2Fpngtree-refresh-icon-for-your-project-png-image_1557315.jpg&type=sc960_832"
                        alt="새로고침" class="page-clear-icon">
                    <input class="check-box" type="checkbox" />
                    <div class="check-box-read point">읽음</div>
                    <div class="check-box-delete point">삭제</div>
                </div>
                <div class="search-zone">
                    <div class="search-area">
                        <input type="text" class="search-input" placeholder="검색할 아이디를 입력하세요." />
                        <button class="search-button">검색</button>
                    </div>
                </div>
                <div class="border">
                    <div class="message-box">
                        <h2 class="text-send-message">받은메세지</h2>
                        <div class="menu-box">
                            <div class="text-menu-message">
                                <div class="text-select">선택</div>
                                <div class="text-recieve">보낸이</div>
                                <div class="text-content">내용</div>
                            </div>
                            <div class="text-content-message">
                                <div class="content-checkbox">
                                    <input class="check-box" type="checkbox" />
                                </div>
                                <div class="content-username">송다함</div>
                                <div class="content-comment">
                                    <div class="comment-date">2024.10.12 00:20</div>
                                    <div class="comment-box">
                                        안녕하세요. 저는 바보 송다함 입니다. 조용하고 한적한곳으로
                                        사람 한명 없어져도 아무도 모르는 그런 곳으로 추천
                                        부탁드려요.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="message-box">
                        <h2 class="text-send-message">받은메세지</h2>
                        <div class="menu-box">
                            <div class="text-menu-message">
                                <div class="text-select">선택</div>
                                <div class="text-recieve">보낸이</div>
                                <div class="text-content">내용</div>
                            </div>
                            <div class="text-content-message">
                                <div class="content-checkbox">
                                    <input class="check-box" type="checkbox" />
                                </div>
                                <div class="content-username">송다함</div>
                                <div class="content-comment">
                                    <div class="comment-date">2024.10.12 00:20</div>
                                    <div class="comment-box">
                                        안녕하세요. 저는 바보 송다함 입니다. 조용하고 한적한곳으로
                                        사람 한명 없어져도 아무도 모르는 그런 곳으로 추천
                                        부탁드려요.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="message-box">
                        <h2 class="text-send-message">받은메세지</h2>
                        <div class="menu-box">
                            <div class="text-menu-message">
                                <div class="text-select">선택</div>
                                <div class="text-recieve">보낸이</div>
                                <div class="text-content">내용</div>
                            </div>
                            <div class="text-content-message">
                                <div class="content-checkbox">
                                    <input class="check-box" type="checkbox" />
                                </div>
                                <div class="content-username">송다함</div>
                                <div class="content-comment">
                                    <div class="comment-date">2024.10.12 00:20</div>
                                    <div class="comment-box">
                                        안녕하세요. 저는 바보 송다함 입니다. 조용하고 한적한곳으로
                                        사람 한명 없어져도 아무도 모르는 그런 곳으로 추천
                                        부탁드려요.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="message-box">
                        <h2 class="text-send-message">받은메세지</h2>
                        <div class="menu-box">
                            <div class="text-menu-message">
                                <div class="text-select">선택</div>
                                <div class="text-recieve">보낸이</div>
                                <div class="text-content">내용</div>
                            </div>
                            <div class="text-content-message">
                                <div class="content-checkbox">
                                    <input class="check-box" type="checkbox" />
                                </div>
                                <div class="content-username">송다함</div>
                                <div class="content-comment">
                                    <div class="comment-date">2024.10.12 00:20</div>
                                    <div class="comment-box">
                                        안녕하세요. 저는 바보 송다함 입니다. 조용하고 한적한곳으로
                                        사람 한명 없어져도 아무도 모르는 그런 곳으로 추천
                                        부탁드려요.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
        <div class="footer">
            <!-- footer 공통파일 -->
            <jsp:include page="../footer.jsp"></jsp:include>
        </div>
    </div>
</body>

</html>