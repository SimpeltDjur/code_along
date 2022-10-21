const handleDelete = id =>
    fetch('/todo/'+id, {method: 'DELETE'})
    .then(res => window.location.href = res.url);