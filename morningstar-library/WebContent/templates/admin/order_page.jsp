<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
    <title>샛별문고</title>
</head>
<body>
<div class="flex flex-col h-screen justify-between">
    <div id="header">
        <header>
            <div class="bg-white">
                <nav class="bg-white border-b border-gray-200 px-4 py-2.5 fixed left-0 right-0 top-0 z-50">
                    <div class="flex flex-wrap justify-between items-center">
                        <div class="flex justify-start items-center">
                            <button data-drawer-target="drawer-navigation"
                                    data-drawer-toggle="drawer-navigation"
                                    aria-controls="drawer-navigation"
                                    class="p-2 mr-2 text-gray-600 rounded-lg cursor-pointer md:hidden hover:text-gray-900 hover:bg-gray-100 focus:bg-gray-100 focus:ring-2 focus:ring-gray-100">
                                <svg aria-hidden="true"
                                     class="w-6 h-6"
                                     fill="currentColor"
                                     viewBox="0 0 20 20"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h6a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                                          clip-rule="evenodd"
                                    ></path>
                                </svg>
                                <svg aria-hidden="true"
                                     class="hidden w-6 h-6"
                                     fill="currentColor"
                                     viewBox="0 0 20 20"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                          clip-rule="evenodd"></path>
                                </svg>
                                <span class="sr-only">Toggle sidebar</span>
                            </button>
                            <a href="/" class="flex items-center justify-between mr-4">
                                <img class="w-10 mr-3" src="../../assets/icons/morningstarlogo.png" alt="logo">
                                <span class="self-center text-2xl font-semibold whitespace-nowrap">ADMINISTRATOR</span>
                            </a>
                        </div>
                        <div class="flex items-center lg:order-2">
                            <a href="/" class="block py-2 px-4 text-sm text-slate-700 font-semibold hover:bg-gray-100">
                                로그아웃</a>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
    </div>

    <section class="bg-white">
        <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
            <div class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
                <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                    <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                        발주
                    </h1>
                    <form class="space-y-4 md:space-y-6" action="#">
                        <div>
                            <label for="name"
                                   class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">이름</label>
                            <input type="text" name="name" id="name"
                                   class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
                                   placeholder="이름" required="">
                        </div>
                        <div>
                            <label for="author"
                                   class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">저자</label>
                            <input type="text" name="author" id="author"
                                   class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
                                   placeholder="저자" required="">
                        </div>
                        <div>
                            <label for="amount"
                                   class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">수량</label>
                            <input type="number" name="amount" id="amount"
                                   class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
                                   placeholder="1" required="">
                        </div>
                        <div>
                            <label for="date"
                                   class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">발주일</label>
                            <input type="date" name="date" id="date"
                                   class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
                                   placeholder="" required="">
                        </div>
                        <div class="text-right">
                            <button type="submit"
                                    class="w-auto text-white bg-sky-700 hover:bg-sky-800 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                                발주
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <div id="footer">
        <footer class="w-full mx-auto border-t border-slate-900/5 bg-white">
            <div class="flex flex-row justify-between mx-auto max-w-[1300px] px-10">
                <div class="float-left mt-10 mb-10">
                    <p class="text-gray-500 text-sm font-bold mb-2">
                        한신대학교
                    </p>
                    <p class="text-gray-500 text-sm font-normal mb-2">
                        6조 | 이승은 이학선 전태준 정민구 정규민
                    </p>
                    <p class="text-gray-500 text-sm font-normal">
                        Copyright ⓒ 6조
                    </p>
                </div>
                <div class="content-center justify-end">
                    <img src="https://www.hs.ac.kr/sites/testPub/images/logo.jpg">
                </div>
            </div>
        </footer>
    </div>
</div>
</body>
</html>