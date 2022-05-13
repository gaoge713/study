function loginApi(data) {
  return $axios({
    'url': 'http://localhost:9300/employee/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': 'http://localhost:9300/employee/logout',
    'method': 'post',
  })
}
